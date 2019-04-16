TEMPLATE = app
CONFIG += console c++11
CONFIG -= app_bundle
CONFIG -= qt

SOURCES += \
        src/main.cpp \
        src/movie_opinion.pb.cc

#INCLUDEPATH += /usr/include/boost/
LIBS += -lboost_system -lprotobuf
#-L "/usr/lib/x86_64-linux-gnu/" -libboost_filesystem.so
#-L"C:\boost\boost_1_59_0\boost-dir\lib" -lboost_filesystem-vc100-mt-1_59

HEADERS += \
    movie_opinion.pb.h
