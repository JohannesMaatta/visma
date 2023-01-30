# visma
Description:

I understood the problem in a way, that I was supposed to parse the uri, and check that the scheme, path and parameters are valid. I was also supposed to return the path and parameters.

In my implementation I parse the uri and check that the scheme is a string and it reads "visma-identity". I also check that the path is a string and it reads "login", "confirm" or "sign". My implementation saves the parameters into a HashMap as key-value pairs, for example {paymentnumber=102226, source=netvisor}. Then it saves the path and the aforementioned HashMap into a new HashMap and returns this, for example "visma-identity://confirm?source=netvisor&paymentnumber=102226" returns {confirm={paymentnumber=102226, source=netvisor}}. 

My implementation is a little lacking, because I ran out of time. We were asked to use two to three hours for this task, I used three. I had to make compromises and in this case it means that my implementation doesnt check if the parameter "payment number" for path "confirm" is integer and it doesnt check if the parameter "documentid" for path "sign" is string. In my opinion these were the best places to compromise on, I believe the checking for those things can be done when sending them, for example only allowing integers and strings on those fields, respectively.
