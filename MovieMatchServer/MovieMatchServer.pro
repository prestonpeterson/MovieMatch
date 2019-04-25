TEMPLATE = app
CONFIG += console c++11
CONFIG -= app_bundle
CONFIG -= qt

SOURCES += \
        src/main.cpp \
        src/movie_match.pb.cc

INCLUDEPATH += "/usr/share/applications/mysql-connector-c++-8.0.15-linux-debian9-x86-64bit/include" \
            src/include
LIBS += -lboost_system -lprotobuf \
        -L "/usr/share/applications/mysql-connector-c++-8.0.15-linux-debian9-x86-64bit/lib64" -lmysqlcppconn \
        /usr/share/applications/mysql-connector-c++-8.0.15-linux-debian9-x86-64bit/lib64/libmysqlcppconn8-static.a \
        -lssl \
        -lcrypto \
        -lpthread

DEFINES += WITH_PROTOBUF=system \
        WITH_QT=ON \
        WITH_GTK=OFF

#-L "/usr/lib/x86_64-linux-gnu/" -libboost_filesystem.so
#-L"C:\boost\boost_1_59_0\boost-dir\lib" -lboost_filesystem-vc100-mt-1_59

HEADERS += \
    UserProfile.h \
    movie_match.pb.h \ \
    src/include/UserProfile.h \
    src/include/movie_match.pb.h \
    src/include/moviedatabase.h
