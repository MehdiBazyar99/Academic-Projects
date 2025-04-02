
from textwrap import wrap


def xor(s1, s2):
    return ''.join(str(ord(a) ^ ord(b)) for a, b in zip(s1, s2))


def hextobin(h):
    return bin(int(h, 16))[2:].zfill(len(h) * 4)


def decode(cipher_list):
    cipher_bin = []
    cipher_len = len(cipher_list)
    for item in cipher_list:
        cipher_bin.append(str(hextobin(item)).zfill(8))

    for i in range(0, 256):
        i = bin(i).zfill(10).replace('0b', '')
        # flag to check if we reached the end of the plaintext
        flag = 0
        plaintext = ""
        for item in cipher_bin:
            if (((int(xor(item, i), 2)) > 64) and ((int(xor(item, i), 2)) < 91)) or (
                    ((int(xor(item, i), 2)) > 96) and ((int(xor(item, i), 2)) < 123)) or (
                    ((int(xor(item, i), 2)) == 32)):
                flag += 1
                plaintext += (str(chr(int(xor(item, i), 2))))

        if (flag + 1) == cipher_len:
            print("plaintText = " + plaintext)
            print("key:  " + i)


def encode(student_number):
    plain_txt = student_number
    cipher_txt = ""
    binary_plain_txt = ""

    for c in plain_txt:
        binary_plain_txt += bin(ord(c)).zfill(10)

    binary_plain_txt = binary_plain_txt.replace("0b", "")
    binary_plain_txt = wrap(binary_plain_txt, 8)
    # key determined from encrypted text
    key = "00001010"
    for c in binary_plain_txt:
        cipher_txt += xor(c, key)
    cipher_text = ""
    cipher_txt = wrap(cipher_txt, 8)
    for c in cipher_txt:
        cipher_text += str(hex(int(c, 2)))

    cipher_text = cipher_text.replace("0x", "")
    cipher_text = wrap(cipher_text, 2)
    print(f"cipher_txt {cipher_text} ")


if __name__ == '__main__':
    cipher = "59 6b 66 6b 67 24 2a 4b 6d 6b 78 2a 7e 7f 64 6f 79 7e 63 2a 63 64 2a 67 6b 7e 64 2a 78 6b 2a " \
             "68 6f 79 62 61 6b 64 63 2a 73 6b 64 63 2a 67 65 7c 6b 6c 6b 6d 62 2a 79 62 65 6e 63"
    cipher_list = cipher.split(' ')
    decode(cipher_list)
    print("---------------------------------------------------------------------")

    student_number = str(971531003)
    encode(student_number)
