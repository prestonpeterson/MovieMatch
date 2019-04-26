import requests
import mysql.connector
from bs4 import BeautifulSoup
import json

def add_critic(conn, cursor, name, url):
    cursor.execute("INSERT IGNORE INTO critics (name, url) VALUES(%s, %s)", (name, url))
    conn.commit()

def add_movie(conn, cursor, name):
    cursor.execute("INSERT IGNORE INTO movies (name) VALUES(%s)", (name,))
    conn.commit()

def parse_critic(conn, cursor, critic, critic_url, html):
    soup = BeautifulSoup(html, "html.parser")

    all_scripts = str(soup.find('script'))
    script = all_scripts.splitlines()[1]

    data = json.loads(script)
    graph = data['@graph']
    subgraph = graph[1]
    itemListElement = subgraph['itemListElement']
    for i in itemListElement:
        item = i['item']
        item_reviewed = item['itemReviewed']
        movie = item_reviewed['name']
        add_movie(conn, cursor, movie)
        review_rating = item['reviewRating']
        rating = review_rating['tomatometer']
        print('critic=', critic, ', movie=', movie, ', rating=', rating, sep='')
        add_critic(conn, cursor, critic, critic_url)


def parse_authors(conn, cursor):
    alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z']
    base_url = 'https://www.rottentomatoes.com/critics/authors?letter='
    for letter in alphabet:
        url = base_url + letter
        response = requests.get(url)
        html = response.content

        soup = BeautifulSoup(html, "html.parser")
        table = soup.find('p', attrs={'class': 'critic-names'})

        tables = soup.find_all('p', attrs={'class': 'critic-names'})

        for table in tables:
            for person in table.findAll('a', attrs={'class': ''}):
                critic_url_suffix = person['href']
                critic_base_url = 'https://www.rottentomatoes.com/critic/'
                critic_url = critic_base_url + critic_url_suffix.partition('/critic/')[2] + '/movies'
                critic = person.text
                response = requests.get(critic_url)
                html = response.content
                parse_critic(conn, cursor, critic, critic_url, html)


if __name__ == '__main__':
    conn = mysql.connector.connect(user='root', password='craft',
                                   host='127.0.0.1',
                                   database='movie_match')
    cursor = conn.cursor()
    parse_authors(conn, cursor)
    conn.close()
