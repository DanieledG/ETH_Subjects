#our password
password = input("Choose a password, use only letters.")
#the text we want to encrypt
plainText = input("Enter the text you want to encrypt, numbers and other special characters won't result in the ciphertext.")
#the alphabet we are going to use
alphabet =["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
#an empty list
cipherText = []
#function that sorts the alphabet using a specific character as the first element
def sortAlphabet (char):
	#tells you at wich position of the alphabet is our charachter
	i = alphabet.index (char)
	#moves the characters from the end of the alphabet to the beginning
	for x in range (0,i):
		alphabet.append (alphabet[0])
		alphabet.remove (alphabet[0])

#function that encrypts the message
def encrypt (password, plainText):
	#counts at which position of the plaintext we are
	i = 0
	#transforms all letters in the plaintext to lowercase
	plainText = plainText.lower()
	#transforms all letters in the password to lowercase
	password = password.lower()
	for l in plainText:
		#if the character we want to encrypt isn't a letter of our alphabet(e.g. a number or a space), it gets removed
		if l not in alphabet:
			#removes the unwanted character
			plainText = plainText.replace(l, "")
		else:
			#sets the alphabet in the usual order ("a" as first character and "z" as last)
			sortAlphabet ("a")
			#the position of that letter in the regular alphabet
			b = alphabet.index (l)
			c = i%len(password)
			#the letter of our password at position c
			d = password[c]
			sortAlphabet(d)
			#inserts the encrypted character in our list
			cipherText.insert(i, alphabet[b])
			#counts at which position of the plaintext we are
			i += 1
	return cipherText

encrypt (password, plainText)
#transforms the ciphertext from a list to a string
cipherText = ''.join(cipherText)
#prints the result
print "ciphertext: ", cipherText
