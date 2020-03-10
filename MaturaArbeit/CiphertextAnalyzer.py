text = input("Please enter the ciphertext you want to analyze")
choice1 = input ("Are you working with the Vigenere-chiffre (v) or with the Caesar-chiffre (c)?")
if choice1 == "v":
	choice = input("Do you want to count the letters on a certain distance (lc) or are you looking for repetitions (r)?")
elif choice1 == "c":
	choice = input("Do you want to analyze letters frequency (lf), bigramms frequency (bf), both (b)?")
else:
	print ("ERROR: Please use one of the above options")

alphabet =["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
cipherText = []

def analyzeLetters(text):
	print ("Letters:")
	for x in range (0,len(text)):
		cipherText.insert(x,text[x])
	for l in alphabet:
		a = cipherText.count(l)
		if a > 0:
			print (l, ":", a)

def analyzeBigramms(text):
	print ("Bigramms:")
	for x in range (1, len(text)):
		cipherText.insert(x-1,text[x-1:x+1])
	for b in cipherText:
		a = cipherText.count(b)
		if a > 1:
			s = alphabet.index(b[1]) - alphabet.index(b[0])
			print (b, ":", a, "; Stellenabstand: ", s)

def searchRepetitions (text,l):
	for x in range (l, len(text)+1):
		cipherText.insert(x-l, text[x-l:x])
	for r in cipherText:
		if r == "****":
			break
		else:
			a = cipherText.count(r)
			if a > 1:
				printer(r,a, cipherText)


def printer (r,a,cT):
	print ("Repetition ", r, "found ", a, "times")
	for y in range (0, a):
		i = cT.index(r)
		print ("The ", y+1, " one at position: ", i)

		cT[i] = "****"

def letterCounter (n):
	for i in range (0, n):
		textI = []
		print ("count n.: ", i + 1)
		l = i
		k = i
		while k < len(text):
			textI.insert(l, text[k])
			k += n
			l += 1
		for l in alphabet:
			a = textI.count(l)
			if a > 0:
				print (l, ":", a)

if choice == "lf":
	analyzeLetters(text)
elif choice == "bf":
	analyzeBigramms(text)
elif choice == "b":
	analyzeLetters(text)
	cipherText = []
	analyzeBigramms(text)
elif choice == "r":
	l = int(input("How many letters should those repetitions have?"))
	searchRepetitions(text,l)
elif choice == "lc":
	n = int(input("How long is the password?"))
	letterCounter(n)
else:
	print ("ERROR: Please use one of the options")
