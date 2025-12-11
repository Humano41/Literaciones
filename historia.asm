section .data
    fmt_int db "%d", 10, 0
    fmt_str db "%s", 10, 0
    fmt_str_str db "%s%s", 0
    fmt_str_int db "%s%d", 0
    fmt_int_str db "%d%s", 0
    cmd_speak_str db "powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%s') > NUL", 0
    cmd_speak_int db "powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%d') > NUL", 0
    str_1988860240_0 db "Iolao", 0
    str_1180573051_1 db "Devorador de Mundos", 0
    str_1251138487_2 db "-----------------------------------------", 0
    str_1059115942_3 db "LA LEYENDA DE ", 0
    str_781403492_4 db " entra a la cueva prohibida...", 0
    str_814715001_5 db "De las sombras surge el ", 0
    str_1193979310_6 db "El combate a muerte comienza!", 0
    str_33700_7 db " ", 0
    str_2118838386_8 db "Round ", 0
    str_2063723306_9 db " Comienza.", 0
    str_2115321587_10 db "PELIGRO! ", 0
    str_1816609457_11 db " bebe una pocion sagrada.", 0
    str_11089927_12 db "Pociones restantes: ", 0
    str_1135025266_13 db "El Dragon esta debil! ", 0
    str_183315352_14 db " prepara un golpe final. (100  de dano)", 0
    str_1081226422_15 db " ataca con su espada. (", 0
    str_1592072116_16 db "  de dano)", 0
    str_33560107_17 db "El ", 0
    str_1353360730_18 db " escupe fuego infernal. (", 0
    str_437452092_19 db "MAGIA ACTIVA! Rafaga de velocidad:", 0
    str_1950898285_20 db "ZAS! Corte rapido (-40 de dano.", 0
    str_781312804_21 db "Vida del Dragon restante:", 0
    str_1290556594_22 db "Vida del Heroe restante:", 0
    str_2018685331_23 db "VICTORIA ABSOLUTA!", 0
    str_399296004_24 db " ha sido derrotado.", 0
    str_1600583395_25 db " regresa al reino como leyenda.", 0
    str_402440766_26 db "GAME OVER", 0
    str_605954821_27 db " ha caido en batalla...", 0

section .bss
    buffer resb 1024
    Heroe resd 1
    VidaHeroe resd 1
    Dragon resd 1
    VidaDragon resd 1
    Daño_dragon resd 1
    Pociones resd 1
    TieneMagia resd 1
    Furia resd 1
    Round resd 1
    AtaqueBase resd 1
    T12 resd 1
    T15 resd 1
    T17 resd 1
    T20 resd 1
    T22 resd 1
    T23 resd 1
    T26 resd 1
    T28 resd 1
    T30 resd 1
    T32 resd 1
    T33 resd 1
    T35 resd 1
    T37 resd 1
    T40 resd 1
    T43 resd 1
    T45 resd 1
    T47 resd 1
    T49 resd 1
    T51 resd 1
    T52 resd 1
    T54 resd 1
    T55 resd 1
    T57 resd 1
    T59 resd 1
    T61 resd 1
    T62 resd 1
    T64 resd 1
    T65 resd 1
    T67 resd 1
    T69 resd 1
    T70 resd 1
    Cortes resd 1
    T73 resd 1
    T74 resd 1
    T77 resd 1
    T78 resd 1
    T81 resd 1
    T85 resd 1
    T89 resd 1
    T93 resd 1
    T96 resd 1
    T98 resd 1
    T100 resd 1
    T103 resd 1

global _main
extern printf
extern sprintf
extern system
extern _exit
extern _strdup

section .text
_main:
    push ebp
    mov ebp, esp

    ; Heroe = "Iolao"
    mov dword [Heroe], str_1988860240_0

    ; VidaHeroe = 100
    mov eax, 100
    mov [VidaHeroe], eax

    ; Dragon = "Devorador de Mundos"
    mov dword [Dragon], str_1180573051_1

    ; VidaDragon = 250
    mov eax, 250
    mov [VidaDragon], eax

    ; Daño_dragon = 101
    mov eax, 101
    mov [Daño_dragon], eax

    ; Pociones = 5
    mov eax, 5
    mov [Pociones], eax

    ; TieneMagia = true
    mov eax, 1
    mov [TieneMagia], eax

    ; Furia = false
    mov eax, 0
    mov [Furia], eax

    ; Round = 1
    mov eax, 1
    mov [Round], eax

    ; AtaqueBase = 50
    mov eax, 50
    mov [AtaqueBase], eax

    ; PRINT "-----------------------------------------"
    ; Imprimir en Pantalla
    push str_1251138487_2
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1251138487_2
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T12 = "LA LEYENDA DE " SUMA "Iolao"
    ; -- Concat --
    push str_1988860240_0
    push str_1059115942_3
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T12], eax

    ; PRINT T12
    ; Imprimir en Pantalla
    push [T12]
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push [T12]
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; PRINT "-----------------------------------------"
    ; Imprimir en Pantalla
    push str_1251138487_2
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1251138487_2
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T15 = "Iolao" SUMA " entra a la cueva prohibida..."
    ; -- Concat --
    push str_781403492_4
    push str_1988860240_0
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T15], eax

    ; PRINT T15
    ; Imprimir en Pantalla
    push [T15]
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push [T15]
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T17 = "De las sombras surge el " SUMA "Devorador de Mundos"
    ; -- Concat --
    push str_1180573051_1
    push str_814715001_5
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T17], eax

    ; PRINT T17
    ; Imprimir en Pantalla
    push [T17]
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push [T17]
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; PRINT "El combate a muerte comienza!"
    ; Imprimir en Pantalla
    push str_1193979310_6
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1193979310_6
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; L0:
L0:

    ; T20 = VidaDragon MAYOR 0
    mov eax, [VidaDragon]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T20], eax

    ; T22 = VidaHeroe MAYOR 0
    mov eax, [VidaHeroe]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T22], eax

    ; T23 = T20 AND T22
    mov eax, [T20]
    and eax, [T22]
    mov [T23], eax

    ; IF T23 GOTO L1
    mov eax, [T23]
    cmp eax, 0
    jne L1

    ; GOTO L2
    jmp L2

    ; L1:
L1:

    ; PRINT " "
    ; Imprimir en Pantalla
    push str_33700_7
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_33700_7
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T26 = "Round " SUMA Round
    ; -- Concat --
    push dword [Round]
    push str_2118838386_8
    push fmt_str_int
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T26], eax

    ; T28 = T26 SUMA " Comienza."
    ; -- Concat --
    push str_2063723306_9
    push [T26]
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T28], eax

    ; PRINT T28
    ; Imprimir en Pantalla
    push [T28]
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push [T28]
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T30 = VidaHeroe MENOR 30
    mov eax, [VidaHeroe]
    cmp eax, 30
    mov eax, 0
    setl al
    mov [T30], eax

    ; T32 = Pociones MAYOR 0
    mov eax, [Pociones]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T32], eax

    ; T33 = T30 AND T32
    mov eax, [T30]
    and eax, [T32]
    mov [T33], eax

    ; IF T33 GOTO L3
    mov eax, [T33]
    cmp eax, 0
    jne L3

    ; GOTO L4
    jmp L4

    ; L3:
L3:

    ; T35 = "PELIGRO! " SUMA Heroe
    ; -- Concat --
    push [Heroe]
    push str_2115321587_10
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T35], eax

    ; T37 = T35 SUMA " bebe una pocion sagrada."
    ; -- Concat --
    push str_1816609457_11
    push [T35]
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T37], eax

    ; PRINT T37
    ; Imprimir en Pantalla
    push [T37]
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push [T37]
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; VidaHeroe = 100
    mov eax, 100
    mov [VidaHeroe], eax

    ; T40 = Pociones RESTA 1
    mov eax, [Pociones]
    sub eax, 1
    mov [T40], eax

    ; Pociones = T40
    mov eax, [T40]
    mov [Pociones], eax

    ; PRINT "Pociones restantes: "
    ; Imprimir en Pantalla
    push str_11089927_12
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_11089927_12
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; PRINT T40
    ; Imprimir en Pantalla
    push dword [T40]
    push fmt_int
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push dword [T40]
    push cmd_speak_int
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; L4:
L4:

    ; T43 = VidaDragon MENOR 200
    mov eax, [VidaDragon]
    cmp eax, 200
    mov eax, 0
    setl al
    mov [T43], eax

    ; IF T43 GOTO L5
    mov eax, [T43]
    cmp eax, 0
    jne L5

    ; GOTO L6
    jmp L6

    ; L5:
L5:

    ; T45 = "El Dragon esta debil! " SUMA Heroe
    ; -- Concat --
    push [Heroe]
    push str_1135025266_13
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T45], eax

    ; T47 = T45 SUMA " prepara un golpe final. (100  de dano)"
    ; -- Concat --
    push str_183315352_14
    push [T45]
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T47], eax

    ; PRINT T47
    ; Imprimir en Pantalla
    push [T47]
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push [T47]
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T49 = VidaDragon RESTA 100
    mov eax, [VidaDragon]
    sub eax, 100
    mov [T49], eax

    ; VidaDragon = T49
    mov eax, [T49]
    mov [VidaDragon], eax

    ; GOTO L7
    jmp L7

    ; L6:
L6:

    ; T51 = Heroe SUMA " ataca con su espada. ("
    ; -- Concat --
    push str_1081226422_15
    push [Heroe]
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T51], eax

    ; T52 = T51 SUMA AtaqueBase
    ; -- Concat --
    push dword [AtaqueBase]
    push [T51]
    push fmt_str_int
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T52], eax

    ; T54 = T52 SUMA "  de dano)"
    ; -- Concat --
    push str_1592072116_16
    push [T52]
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T54], eax

    ; PRINT T54
    ; Imprimir en Pantalla
    push [T54]
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push [T54]
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T55 = VidaDragon RESTA AtaqueBase
    mov eax, [VidaDragon]
    sub eax, [AtaqueBase]
    mov [T55], eax

    ; VidaDragon = T55
    mov eax, [T55]
    mov [VidaDragon], eax

    ; L7:
L7:

    ; T57 = VidaDragon MAYOR 0
    mov eax, [VidaDragon]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T57], eax

    ; IF T57 GOTO L8
    mov eax, [T57]
    cmp eax, 0
    jne L8

    ; GOTO L9
    jmp L9

    ; L8:
L8:

    ; T59 = "El " SUMA Dragon
    ; -- Concat --
    push [Dragon]
    push str_33560107_17
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T59], eax

    ; T61 = T59 SUMA " escupe fuego infernal. ("
    ; -- Concat --
    push str_1353360730_18
    push [T59]
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T61], eax

    ; T62 = T61 SUMA Daño_dragon
    ; -- Concat --
    push dword [Daño_dragon]
    push [T61]
    push fmt_str_int
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T62], eax

    ; T64 = T62 SUMA "  de dano)"
    ; -- Concat --
    push str_1592072116_16
    push [T62]
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T64], eax

    ; PRINT T64
    ; Imprimir en Pantalla
    push [T64]
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push [T64]
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T65 = VidaHeroe RESTA Daño_dragon
    mov eax, [VidaHeroe]
    sub eax, [Daño_dragon]
    mov [T65], eax

    ; VidaHeroe = T65
    mov eax, [T65]
    mov [VidaHeroe], eax

    ; L9:
L9:

    ; T67 = TieneMagia IGUAL_QUE true
    mov eax, [TieneMagia]
    cmp eax, 1
    mov eax, 0
    sete al
    mov [T67], eax

    ; T69 = VidaHeroe MAYOR 0
    mov eax, [VidaHeroe]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T69], eax

    ; T70 = T67 AND T69
    mov eax, [T67]
    and eax, [T69]
    mov [T70], eax

    ; IF T70 GOTO L10
    mov eax, [T70]
    cmp eax, 0
    jne L10

    ; GOTO L11
    jmp L11

    ; L10:
L10:

    ; PRINT "MAGIA ACTIVA! Rafaga de velocidad:"
    ; Imprimir en Pantalla
    push str_437452092_19
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_437452092_19
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; Cortes = 3
    mov eax, 3
    mov [Cortes], eax

    ; T73 = 3
    mov eax, 3
    mov [T73], eax

    ; L12:
L12:

    ; T74 = T73 MAYOR 0
    mov eax, [T73]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T74], eax

    ; IF T74 GOTO L13
    mov eax, [T74]
    cmp eax, 0
    jne L13

    ; GOTO L14
    jmp L14

    ; L13:
L13:

    ; PRINT "ZAS! Corte rapido (-40 de dano."
    ; Imprimir en Pantalla
    push str_1950898285_20
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1950898285_20
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T77 = VidaDragon RESTA 40
    mov eax, [VidaDragon]
    sub eax, 40
    mov [T77], eax

    ; VidaDragon = T77
    mov eax, [T77]
    mov [VidaDragon], eax

    ; T78 = T73 RESTA 1
    mov eax, [T73]
    sub eax, 1
    mov [T78], eax

    ; T73 = T78
    mov eax, [T78]
    mov [T73], eax

    ; GOTO L12
    jmp L12

    ; L14:
L14:

    ; TieneMagia = false
    mov eax, 0
    mov [TieneMagia], eax

    ; L11:
L11:

    ; T81 = VidaDragon MENOR 0
    mov eax, [VidaDragon]
    cmp eax, 0
    mov eax, 0
    setl al
    mov [T81], eax

    ; IF T81 GOTO L15
    mov eax, [T81]
    cmp eax, 0
    jne L15

    ; GOTO L16
    jmp L16

    ; L15:
L15:

    ; VidaDragon = 0
    mov eax, 0
    mov [VidaDragon], eax

    ; L16:
L16:

    ; PRINT "Vida del Dragon restante:"
    ; Imprimir en Pantalla
    push str_781312804_21
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_781312804_21
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; PRINT VidaDragon
    ; Imprimir en Pantalla
    push dword [VidaDragon]
    push fmt_int
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push dword [VidaDragon]
    push cmd_speak_int
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T85 = VidaHeroe MENOR 0
    mov eax, [VidaHeroe]
    cmp eax, 0
    mov eax, 0
    setl al
    mov [T85], eax

    ; IF T85 GOTO L17
    mov eax, [T85]
    cmp eax, 0
    jne L17

    ; GOTO L18
    jmp L18

    ; L17:
L17:

    ; VidaHeroe = 0
    mov eax, 0
    mov [VidaHeroe], eax

    ; L18:
L18:

    ; PRINT "Vida del Heroe restante:"
    ; Imprimir en Pantalla
    push str_1290556594_22
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1290556594_22
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; PRINT VidaHeroe
    ; Imprimir en Pantalla
    push dword [VidaHeroe]
    push fmt_int
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push dword [VidaHeroe]
    push cmd_speak_int
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T89 = Round SUMA 1
    mov eax, [Round]
    add eax, 1
    mov [T89], eax

    ; Round = T89
    mov eax, [T89]
    mov [Round], eax

    ; GOTO L0
    jmp L0

    ; L2:
L2:

    ; PRINT " "
    ; Imprimir en Pantalla
    push str_33700_7
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_33700_7
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; PRINT "-----------------------------------------"
    ; Imprimir en Pantalla
    push str_1251138487_2
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1251138487_2
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T93 = VidaHeroe MAYOR 0
    mov eax, [VidaHeroe]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T93], eax

    ; IF T93 GOTO L19
    mov eax, [T93]
    cmp eax, 0
    jne L19

    ; GOTO L20
    jmp L20

    ; L19:
L19:

    ; PRINT "VICTORIA ABSOLUTA!"
    ; Imprimir en Pantalla
    push str_2018685331_23
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_2018685331_23
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T96 = "El " SUMA Dragon
    ; -- Concat --
    push [Dragon]
    push str_33560107_17
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T96], eax

    ; T98 = T96 SUMA " ha sido derrotado."
    ; -- Concat --
    push str_399296004_24
    push [T96]
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T98], eax

    ; PRINT T98
    ; Imprimir en Pantalla
    push [T98]
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push [T98]
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T100 = Heroe SUMA " regresa al reino como leyenda."
    ; -- Concat --
    push str_1600583395_25
    push [Heroe]
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T100], eax

    ; PRINT T100
    ; Imprimir en Pantalla
    push [T100]
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push [T100]
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; GOTO L21
    jmp L21

    ; L20:
L20:

    ; PRINT "GAME OVER"
    ; Imprimir en Pantalla
    push str_402440766_26
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push str_402440766_26
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; T103 = Heroe SUMA " ha caido en batalla..."
    ; -- Concat --
    push str_605954821_27
    push [Heroe]
    push fmt_str_str
    push buffer
    call sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T103], eax

    ; PRINT T103
    ; Imprimir en Pantalla
    push [T103]
    push fmt_str
    call printf
    add esp, 8
    ; Narrar con PowerShell
    push [T103]
    push cmd_speak_str
    push buffer
    call sprintf
    add esp, 12
    push buffer
    call system
    add esp, 4

    ; L21:
L21:

    push 0
    call _exit
