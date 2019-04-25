#ifndef USERPROFILE_H
#define USERPROFILE_H

#include <map>
#include <string>


enum class Opinion {

    Like,
    Dislike,

};

class UserProfile {

public:
    std::map<std::string, Opinion> opinions;

    void SetOpinion(std::string movie_name, bool opinion) {
        if (opinion) {
            opinions[movie_name] = Opinion::Like;
        }
        else {
            opinions[movie_name] = Opinion::Dislike;
        }
    }

};

#endif // USERPROFILE_H
