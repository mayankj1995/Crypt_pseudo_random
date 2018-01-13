# Encyption using Pseudo Random numbers

This program is used to crypt txt files using pseudo random numbers
- I created the algorithm to create pseudo random numbers myself.

# Randomize.java
This class is used to create pseudo random numbers
When you provide this program with a number - it creates a unique sequence of numbers 

# Crypt.java
This program crypts the message in 'input.txt. text file using the Randomize class
- It asks you for an input - the secret key - that you later used to decrypt the file as well
- It outupts another txt file - 'output.txt' which has the message encrypted

# Decrypt.java
This program decypts the message in 'output.txt' text file using the same Randomize class
- It asks you for an input - the secret key - the same key that you used to encrypt it
- It outupts another txt file - 'decrypted.txt' which gets you the original txt back

# How to run
You can compile any file using the javac command
Example - javac Crypt.java

You can run the file using java command once you have it compiled
Example - java Crypt
