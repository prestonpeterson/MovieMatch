#include <ctime>
#include <iostream>
#include <string>
#include <boost/asio.hpp>
#include "movie_opinion.pb.h"


using boost::asio::ip::tcp;

std::string make_daytime_string()
{
  std::time_t now = std::time(nullptr);
  return std::ctime(&now);
}

std::vector<char> buffer(2056);

void ReadHandler(boost::system::error_code ex){
    std::cout << " print the buffer data..." << std::endl;
    std::cout << buffer.data() << std::endl;
}

int main()
{

  try
  {
    // Any program that uses asio need to have at least one io_service object
    boost::asio::io_service io_service;

    std::cout << "Creating connection acceptor..." << std::endl;
    // acceptor object needs to be created to listen for new connections
    tcp::acceptor acceptor(io_service, tcp::endpoint(tcp::v4(), 44444));

    for (;;)
    {
      std::cout << "Creating socket..." << std::endl;
      // creates a socket
      tcp::socket socket(io_service);

      std::cout << "Waiting for connection..." << std::endl;
      // wait and listen
      acceptor.accept(socket);

      socket.read_some(boost::asio::buffer(buffer));
      ReadHandler(boost::system::error_code());

//      MovieOpinion movieOpinion;
//      std::istream input;
//      movieOpinion.ParseFromIstream(&input);
      // prepare message to send back to client
      std::string message = make_daytime_string();

      boost::system::error_code ignored_error;

      std::cout << "Writing message" << std::endl;
      // writing the message for current time
      boost::asio::write(socket, boost::asio::buffer(message), ignored_error);
    }
  }
  catch (std::exception& e)
  {
    std::cerr << e.what() << std::endl;
  }

  return 0;
}
