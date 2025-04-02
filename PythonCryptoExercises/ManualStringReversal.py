import base64
import sys


def decode(message):
    base64_message = message
    base64_bytes = base64_message.encode('ascii')
    message_bytes = base64.b64decode(base64_bytes)
    message = message_bytes.decode('ascii')
    return message

def encode(message):
    message = message.encode('ascii')
    message_bytes = base64.b64encode(message)
    message = message_bytes.decode('ascii')

    return message

def shift_encode(message):
    message = message.lower()
    letters = 'abcdefghijklmnopqrstuvwxyz'
    key = 15
    translated = ''
    for symbol in message:
        if symbol in letters:
            num = letters.find(symbol)
            num = num + key
            if num > 26:
                num = num - len(letters)
            translated = translated + letters[num]
        else:
            translated = translated + symbol
    print("encoded message with "+ str(key) + " as key --> " + translated)
    print("base64 encoded message ---->  " + encode(message))


def shift_decode(message):
    letters = 'abcdefghijklmnopqrstuvwxyz'
    for key in range(len(letters)):
        translated = ''
        for symbol in message:
            if symbol in letters:
                num = letters.find(symbol)
                num = num - key
                if num < 0:
                    num = num + len(letters)
                translated = translated + letters[num]
            else:
                translated = translated + symbol
        print("decoded message with "+str(key) + " as key --> " + translated)




if __name__ == '__main__':
    message = "bHd0Y2x4YWFsdHZncHNqcGl0"
    message = decode(message)
    print("message decoded from base64 --> "+message)
    print("---------------------------------------------------------------")
    shift_decode(message)
    print("--------------------------------------------------------------")
    name = 'MehdiBazyar'
    shift_encode(name)

