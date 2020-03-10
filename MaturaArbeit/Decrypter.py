#our password
password = input("Choose a password, use only letters: ")
#the text we want to decrypt
cipherText = input("Enter the text you want to decrypt: ")
#the alphabet we are going to use
alphabet = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
#an empty list
plainText = []
#function that sorts the alphabet using a given character as the first element
def sortAlphabet (char):
#tells you at wich position of the alphabet is our charachter
    i = alphabet.index (char)
#moves the characters from the end of the alphabet to the beginning
    for x in range (0, i):
        alphabet.append (alphabet[0])
        alphabet.remove (alphabet[0])
def decrypt (password, cipherText):
    i = 0
    cipherText = cipherText.lower()
#transforms all letters in the password to lowercase
    password = password.lower()
    for l in cipherText:
        if l in alphabet:
            c = i%len(password)
            d = password[c]
            sortAlphabet (d)
            b = alphabet.index(l)
            sortAlphabet ("a")
            plainText.insert(i, alphabet[b])
            i += 1
    return plainText

decrypt (password, cipherText)
plainText = ''.join(plainText)
print ("plaintext: ", plainText)

