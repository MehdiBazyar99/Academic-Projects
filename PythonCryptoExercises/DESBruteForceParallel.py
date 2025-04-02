import asyncio
import time
import base64
from des import DesKey

def background(f):
    def wrapped(*args, **kwargs):
        return asyncio.get_event_loop().run_in_executor(None, f, *args, **kwargs)

    return wrapped

@background
def decodeDES_1(plaintext, ciphertext): # Added another argument
    time.sleep(5)
    cipher = ciphertext.encode('ascii')
    cipher = base64.b64decode(cipher) 
    start_time = time.perf_counter()
    for i in range(0,25000000):
        
        createKey = str(i).zfill(8)
        key = DesKey(str.encode(createKey))
        text=key.decrypt(cipher)
        if text == str.encode(plaintext):
            print('key= ',createKey)
            break
        else:
            print("Number #"+str(i))
    elapsed_time = time.perf_counter() - start_time
    print("it took " + str(elapsed_time) + " seconds")


@background
def decodeDES_2(plaintext, ciphertext): # Added another argument
    time.sleep(5)
    cipher = ciphertext.encode('ascii')
    cipher = base64.b64decode(cipher) 
    start_time = time.perf_counter()
    for i in range(25000000,50000000):
        
        createKey = str(i).zfill(8)
        key = DesKey(str.encode(createKey))
        text=key.decrypt(cipher)
        if text == str.encode(plaintext):
            print('key= ',createKey)
            break
        else:
            print("Number #"+str(i))
    elapsed_time = time.perf_counter() - start_time
    print("it took " + str(elapsed_time) + " seconds")

@background
def decodeDES_3(plaintext, ciphertext): # Added another argument
    time.sleep(5)
    cipher = ciphertext.encode('ascii')
    cipher = base64.b64decode(cipher) 
    start_time = time.perf_counter()
    for i in range(50000000,75000000):
        
        createKey = str(i).zfill(8)
        key = DesKey(str.encode(createKey))
        text=key.decrypt(cipher)
        if text == str.encode(plaintext):
            print('key= ',createKey)
            break
        else:
            print("Number #"+str(i))
    elapsed_time = time.perf_counter() - start_time
    print("it took " + str(elapsed_time) + " seconds")

@background
def decodeDES_4(plaintext, ciphertext): # Added another argument
    time.sleep(5)
    cipher = ciphertext.encode('ascii')
    cipher = base64.b64decode(cipher) 
    start_time = time.perf_counter()
    for i in range(75000000,100000000):
        
        createKey = str(i).zfill(8)
        key = DesKey(str.encode(createKey))
        text=key.decrypt(cipher)
        if text == str.encode(plaintext):
            print('key= ',createKey)
            break
        else:
            print("Number #"+str(i))
    elapsed_time = time.perf_counter() - start_time
    print("it took " + str(elapsed_time) + " seconds")



def encodedes(plaintext,password):
    key= DesKey((str.encode(password)))
    return key.encrypt((str.encode(plaintext)),padding=True)

def code_to_run_before():
    decodeDES_1('Break me',"OsQFp1sqAEo=")    #key=  02062440



def code_to_run_after():
    cipher=encodedes('971531003','02062440')    #b'\x9c\xfd\xdbQ9\xb0A%\x13\xfc\xc3\xb0`\x93\xd5\xa2'
    cipher64=base64.b64encode(cipher).decode('ascii')   #nP3bUTmwQSUT/MOwYJPVog==
    print(cipher64)


plaintext='Break me'
ciphertext="OsQFp1sqAEo="





code_to_run_before()                                                         # Anything you want to run before, run here!   

loop = asyncio.get_event_loop()                                              # Have a new event loop

group1 = asyncio.gather(*[decodeDES_1(i, 1) for i in range(1, 2)])         # Run all the loops you want
group2 = asyncio.gather(*[decodeDES_2(i, 2) for i in range(3, 5)])         # Run all the loops you want
group3 = asyncio.gather(*[decodeDES_3(i, 3) for i in range(6, 9)])         # Run all the loops you want
group4 = asyncio.gather(*[decodeDES_4(i, 4) for i in range(10, 13)])         # Run all the loops you want

all_groups = asyncio.gather(group1, group2, group3,group4)                          # Gather them all                                    
results = loop.run_until_complete(all_groups)                                # Wait until finish

code_to_run_after()  