# AddressBook Search System

Description:
In this project, I use HashMap to store the dataset. I build four HashMaps. They use FisrtName, LastName, PhoneNumber and CityName as their key separately and the whole information as the value. The user just needs to provide the key, the whole information can be provided. However, this project requires input partial words. Therefore, I use the startsWith() function, which is provided by java, to find all of the results that start with the key words that the user provides.

Analysis:
To make a searching work without having to sort it on every request, we can build four lists at first, and then find a way to search the key word in lists. As I build four HashMaps at first, we do not have to sort the list on every request.
In this project, Binary Search is a very fast method to search data. However, the Binary Search can only return one result on every request. Therefore, if we want to return m results, the time is O(mlog(n)).
Therefore, to reduce the search time, we should find a better data structure to store data. In this project, I analyze 3 kind of data structure and finally, I choose the HashMap.
TreeMap & HashMap: The TreeMap can sort the list automatically when we insert the data into it, but its average searching time is O(log(n)). Compared with TreeMap, the HashMap is faster, the average search time is O(1). So if we want to return m results. The search time of TreeMap is O(mlog(n)), the HashMap is O(m). Then we can use the startsWith() function to return the matched results, which does not cost too much time.
Trie: It is true that the search time of Trie tree is very fast, it just take O(len) time(len is the length of word that user requests). The total searching time is O(len). However, after we find the prefix node in the Trie, we need to traverse the tree and return the matched results. The time to traverse the tree is O(m*n)(m is the average length of words that matched) because the Trie store every character of the words. It cost too much time.

Conclusion:
As a result, I choose the fastest way, HashMap, to store data.

