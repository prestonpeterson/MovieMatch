* Populate movie list from server for autocomplete:
  * Have server periodically push movie list to all user apps.
  * Or have app periodically request movie list from server.
  * Movie list request should probably only request movies added after a specific time, rather than requesting the ENTIRE list of movies every time.
* Populate user_movies table, server-side, upon receipt of MovieOpinion protos.
* Implement match algorithm, server-side.

