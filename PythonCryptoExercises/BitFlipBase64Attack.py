
from base64 import b64decode, b64encode
cipher_base64 = "yPQ2zpXT/rtd/nI13tOGDkER9VUf6Lye40tfQzVhoud8+RPxJIlctu/y0ataF1LQ"

def changeBit(pos, data):
    raw = b64decode(data)
    xored_list = list(raw)
    xored_list[pos] ^= 1
    return b64encode(bytes(xored_list))
    
print(changeBit(39, cipher_base64))