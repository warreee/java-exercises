# Assignment

A science conference consists of organisers, authors & guests. 

For each individual are kept a name, address and phone. 
Authors can join with individual or collaborative papers. 
For each author there's a count of the number of articles that he participates with. 

Each article has a title, description, up to 4 keywords and main body of text.
For collaborative articles, additionally there's a record of the individual contribution of each author as a percentage.

Each article goes through three stages - new (doesn't have a reviewer), processing (has a reviewer but not ready) & ready (a reviewer has either accepted or rejected it).

A reviewer can be only someone from the organisers of the conference. 
Organisers can also author articles. 
However an authoring organiser cannot review his/her own article.

Organisers have a password, which is used as a verificaiton method when reviewing an article - there's a verifyPass(String pwd).

For articles, there are several methods:
* getAuthor()/getAuthor(int i) - without arguments returns the name of the first author, otherwise the name of the ith author
* getStatus() - current stage of the article
* changeStatus(Reviewer r, String password, ...)  - given arguments, 
changes the status of an article (i.e. can change the stage or/and add reviewers, one of the args should be the password so that the reviewer can be verified) 


Use the Exception class when you want to throw an exception (i.e. don't create your own exception classes)