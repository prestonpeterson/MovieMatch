#include <ctime>
#include <iostream>
#include <string>
#include <boost/asio.hpp>
#include <boost/asio/ip/address.hpp>
#include <google/protobuf/message_lite.h>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/util/delimited_message_util.h>
//#include <mysqlx/xdevapi.h>

#include "movie_match.pb.h"
#include "UserProfile.h"
#include "mysql_driver.h"
#include <mysqlx/xdevapi.h>


using boost::asio::ip::tcp;

std::string make_daytime_string()
{
    std::time_t now = std::time(nullptr);
    return std::ctime(&now);
}

typedef uint64_t user_id;

int main()
{
    std::map<user_id, UserProfile> user_profiles;

    try
    {
        sql::mysql::MySQL_Driver *driver;
        sql::Connection *con;
        sql::Statement *stmt;
//        sql::SQLString
        driver = sql::mysql::get_driver_instance();

        std::string db_ip = "127.0.0.1";
        unsigned short db_port = 3306;

        con = driver->connect("tcp://" + db_ip + ":" + std::to_string(db_port), "root", "craft");
        /* Connect to the MySQL test database */
        con->setSchema("movie_match");
        stmt = con->createStatement();
        stmt->executeQuery("SELECT 'Hello World!' AS _message");

//          res = stmt->executeQuery("SELECT 'Hello World!' AS _message");
//          while (res->next()) {
//            cout << "\t... MySQL replies: ";
//            /* Access column data by alias or column name */
//            cout << res->getString("_message") << endl;
//            cout << "\t... MySQL says it again: ";
//            /* Access column data by numeric offset, 1 is the first column */
//            cout << res->getString(1) << endl;
//          }

        std::string server_ip = "100.115.92.194";
        unsigned short server_rcv_port = 44444;
        std::cout << "Creating connection endpoint at " << server_ip << ":" << server_rcv_port << "..." << std::endl;
        tcp::endpoint endpoint(boost::asio::ip::address::from_string(server_ip), server_rcv_port);
        std::cout << "Creating connection acceptor..." << std::endl;
        // Any program that uses asio need to have at least one io_service object
        boost::asio::io_service io_service;
        tcp::acceptor acceptor(io_service, endpoint);

        for (;;)
        {
            std::cout << "Creating socket..." << std::endl;
            // creates a socket
            tcp::socket socket(io_service);

            std::cout << "Waiting for connection..." << std::endl;
            acceptor.accept(socket);

            std::cout << "Connection established. Waiting for message..." << std::endl;
            const size_t k_buffer_size = 1024;
            char buffer[k_buffer_size];

            boost::system::error_code ec;
            size_t size = boost::asio::read(socket, boost::asio::buffer(buffer, k_buffer_size), ec);
            std::cout << "Received message of size " << size << "." << std::endl;
            google::protobuf::io::ArrayInputStream arr(buffer, size);
            google::protobuf::io::CodedInputStream input(&arr);
            MovieOpinion movieOpinion;
            bool clean_eof;
            google::protobuf::util::ParseDelimitedFromCodedStream(&movieOpinion, &input, &clean_eof);

            std::cout << "User = " << movieOpinion.user_id() << ". Movie = " << movieOpinion.movie_name() << ". Thumbs up = " <<
                         std::boolalpha << movieOpinion.thumbs_up() << std::endl;

            user_profiles[movieOpinion.user_id()].SetOpinion(movieOpinion.movie_name(), movieOpinion.thumbs_up());
        }
    }
    catch (std::exception& e)
    {
        std::cerr << e.what() << std::endl;
    }

    return 0;
}
