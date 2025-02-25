def is_valid_alphabet(alphabet):
    if len(alphabet) == 0:
        return False
    
    # Step 2: Check prefix relationships
    for i in range(len(alphabet) - 1):
        currToken = alphabet[i]                 # Grab the current token
        for j in range(i+1, len(alphabet)):     # Check with all the tokens after the current token
            nextToken = alphabet[j]             # Grab the next token
            if nextToken.startswith(currToken):         # Check for prefix relationship
                return False                    # currToken is a prefix of nextToken
    
    return True


test1 = []                                     # invalid
test2 = ['a', 'ba', 'da', 'aba']               # invalid
test3 = ['b', 'ab', 'aab', 'aaab', 'aaabb']    # invalid
test4 = ['b', 'aba', 'ab', 'a']                # valid

tests = [test1, test2, test3, test4]

for test in tests:
    print("Σ = ", test, end=" \t ")
    if is_valid_alphabet(test):
        print("Valid alphabet")
    else:
        print("Invalid alphabet")



# __________________________________________________
# if is_valid_alphabet(testAlphabet):
#     print("Valid alphabet")
# else:
#     print("Invalid alphabet")


# Step 1: Sort tokens by length
# sorted_tokens = sorted(tokens, key=lambda x: len(x))