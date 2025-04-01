	%include "asm_io.inc"
	
	
	
	
	segment .data 
	
; DX directives
        prompt db    "Enter the desired number: ", 0

	isPerfect db "The number you entered is perfect.",0
	
	notPerfect db "The number you entered is not perfect.",0
	
 
     		
        segment .bss 

; RESX directives
     
     
     

	segment .text

	
	global asm_main


asm_main:

	enter 0,0
	pusha
	
				;write your code here
	; ask user to input a number 
	mov eax,prompt
	call print_string
	
        ; set eax to 0 
	mov eax,0
	
	call read_int 
	mov ecx,eax
	mov esi,eax 
	mov ebx,0
	

 ; main loop of the program 

Loop:

; subtract 1 unit from ecx (the number user entered)
  sub ecx,1
; set eax to input number
  mov eax,esi
; check if ecx minus 1 equals to zero and if it does, exit the loop
  sub ecx,0
  
  je exitLoop
  
; set the remainder register as zero 
  mov edx,0
; divide the number by ecx 
  div ecx 
; check if remainder equals to zero (i.e the number doesnt have any remainder)
  sub edx,0
; if it does, jump to L1
  je L1
  
 ;if it doesnt, go to the start of the loop and try the next number  
  sub edx,0
  jne Loop
	

exitLoop: 
;compare eax (ie user number ) and ebx ( ie sum of it's divisors) with each other, if these two where equal, go to Perfect and they werent, go to nPerfect
sub eax,ebx
je Perfect

sub eax,ebx
jne nPerfect

	
	
L1:
	; here we add the divisor of the entered number together and save it in ebx register
	add ebx,ecx
	; get back to loop
	sub edx,0
	je Loop
	
	
	; let the user know that the entered number isnt perfect	
Perfect:
	mov eax,isPerfect
	call print_string
	call print_nl
	jmp endl
	
	; let the user know that the entered number is perfect

nPerfect:

	mov eax,notPerfect
	call print_string
	call print_nl
	jmp endl
	
endl:
	
	
	dump_regs 1

	popa
	leave
	ret
	
	
	
	


	




