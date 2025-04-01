	%include "asm_io.inc"
	
	
	
	
	
	segment .data 
; DX directives
    
        
        first   dq 0x1000000000000000
        second  dq 0x1000000000000000
        

     
     	
     	
        segment .bss 

; RESX directives
     
	


	segment .text

	global asm_main

asm_main:

	enter 0,0
	pusha

				;write your code here
	
        mov edx, [first]     ; bits 0..31
	
	mov ecx, [first + 4] ; bits 32..63

	add [second], edx
	adc [second + 4], ecx
	
	mov eax,[second]
	call print_int 
	call print_nl
	
	mov eax,[second+4]
	call print_int
	call print_nl

	

	
	dump_regs 1

	popa
	leave
	ret
	

	
