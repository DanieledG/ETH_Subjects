#our "password"
key = int(input("Choose a number between 1 and 25"))
#the text we want to encrypt
plainText = input("Enter the text you want to encrypt. Numbers and other special characters aren't going to be encrypted")
#the alphabet we are going to use
alphabet = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q", "r","s","t","u","v","w","x","y","z"]
#an empty list
cipherText = []
def encrypt (key, plainText):
	i = 0
	plainText = plainText.lower()
	for l in plainText:
		if l not in alphabet:
			plainText = plainText.replace(l, "")
		else:
			x = (alphabet.index(l)+key)%len(alphabet)
			cipherText.insert(i,alphabet[x])
			i += 1
	return cipherText

#transforms the plaintext to the ciphertext
encrypt (key, plainText)
#transforms the ciphertext from a list to a string
cipherText = ''.join(cipherText)
#prints the result
print ("ciphertext: ", cipherText)
