.data
	Month: .space 48
	
	promptForYearOfBirth: .asciiz "Enter your year of birth: "
	promptForMonthOfBirth: .asciiz "Enter your month of birth: "
	promptForDayOfBirth: .asciiz "Enter your day of birth: "
	
	promptForCurrentYear: .asciiz "Enter current year: "
	promptForCurrentMonth: .asciiz "Enter current month: "
	promptForCurrentDay: .asciiz "Enter current day: "
	
	printAge: .asciiz "\nYou are "
	userYear: .asciiz " year's and "
	userMonth: .asciiz " month's and "
	userDay: .asciiz " Day's old."


.text
	
	#Here we add number of days in different months
	# Index/ Offset = $t0
	addi $t0, $zero, 0
	
	#1
	addi $s0, $zero, 31
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	 #2   
        addi $s0, $zero, 28
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	#3
	addi $s0, $zero, 31
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	#4   
        addi $s0, $zero, 30
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	#5
	addi $s0, $zero, 31
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	#6    
        addi $s0, $zero, 30
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	#7
	addi $s0, $zero, 31
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	#8    
        addi $s0, $zero, 31
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	#9
	addi $s0, $zero, 30
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	#10    
        addi $s0, $zero, 31
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	#11
	addi $s0, $zero, 30
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	#12    
        addi $s0, $zero, 31
	sw $s0, Month($t0)
	addi $t0,$t0, 4
	
	
	
	main:
	
	#promt the user to enter day of birth 
	li $v0, 4 #the code to display string is 4
	la $a0, promptForDayOfBirth
	syscall 
	
	
	#Get the user's day of birth
	li $v0,5 #this the ins that tells the system that we want to get an int from the user
	syscall
	#the number is gonna be saved in v0
	
	#store the result in $t0
	move $t0,$v0
	
	
	#promt the user to enter month of birth 
	li $v0, 4 #the code to display string is 4
	la $a0, promptForMonthOfBirth
	syscall 
	
	
	#Get the user's month of birth
	li $v0,5 #this the ins that tells the system that we want to get an int from the user
	syscall
	#the number is gonna be saved in v0
	
	#store the result in $t0
	move $t1,$v0
	
	#promt the user to enter year of birth 
	li $v0, 4 #the code to display string is 4
	la $a0, promptForYearOfBirth
	syscall 
	
	
	#Get the user's year of birth 
	li $v0,5 #this the ins that tells the system that we want to get an int from the user
	syscall
	#the number is gonna be saved in v0
	
	#store the result in $t0
	move $t2,$v0
	
	
	#promt the user to enter current day 
	li $v0, 4 #the code to display string is 4
	la $a0, promptForCurrentDay
	syscall 
	
	
	#Get current day 
	li $v0,5 #this the ins that tells the system that we want to get an int from the user
	syscall
	#the number is gonna be saved in v0
	
	#store the result in $t0
	move $t3,$v0
	
	
	#promt the user to enter current month 
	li $v0, 4 #the code to display string is 4
	la $a0, promptForCurrentMonth
	syscall 
	
	
	#Get the current month 
	li $v0,5 #this the ins that tells the system that we want to get an int from the user
	syscall
	#the number is gonna be saved in v0
	
	#store the result in $t0
	move $t4,$v0
	
	#promt the user to enter current year 
	li $v0, 4 #the code to display string is 4
	la $a0, promptForCurrentYear
	syscall 
	
	
	#Get the current year 
	li $v0,5 #this the ins that tells the system that we want to get an int from the user
	syscall
	#the number is gonna be saved in v0
	
	#store the result in $t0
	move $t5,$v0
	
	j calculateAge
	
	#end program
	li $v0, 10
	syscall
	
	
	calculateAge:
	#if birth date is greater then current  
        #birth_date, then donot count this month 
        #and add 30 to the date so as to subtract  
        #the date and get the remaining days 
	bgt $t0,$t3,birthDayGreaterThanCurrentDay
	currentDayPass:
	
	#if birth month exceeds current month,  
        #then do not count this year and add  
        #12 to the month so that we can subtract 
        #and find out the difference
	bgt $t1,$t4,birthMonthGreaterThanCurrentMonth
	currentMonthPass:
	
	#calculate date, month, year 
	sub $s0,$t3,$t0
	sub $s1,$t4,$t1
	sub $s2,$t5,$t2
	
	#DisplayAgeMessage 
	li $v0,4
	la $a0, printAge
	syscall
	
	#print year of age
	li $v0,1 #to print an integer, the code is 1
	addi $a0,$s2,0
	syscall
	#DisplayYearMessage
	li $v0,4
	la $a0, userYear
	syscall
	
	#print month of age
	li $v0,1 #to print an integer, the code is 1
	addi $a0,$s1,0
	syscall
	
	#DisplayMonthMessage
	li $v0,4
	la $a0, userMonth
	syscall
	
	#print day of age
	li $v0,1 #to print an integer, the code is 1
	addi $a0,$s0,0
	syscall
	
	#DisplayDayMessage
	li $v0,4
	la $a0, userDay
	syscall
	
	
	#end program
	li $v0, 10
	syscall
	

	birthDayGreaterThanCurrentDay:
	sub $t1,$t1,1
	#t6 is temporary
	#here it saves month[birth_month - 1] value
	sw $t6, Month($t1)
	sub $t6,$t6,1
	add $t3,$t3,$t6
	
	j currentDayPass

	birthMonthGreaterThanCurrentMonth:
	sub $t5,$t5,1
	add $t4,$t4,12
	
	j currentMonthPass
	