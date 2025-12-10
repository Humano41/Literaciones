section .data
    fmt_int db "%d", 10, 0
    fmt_str db "%s", 10, 0
    fmt_str_str db "%s%s", 0
    fmt_str_int db "%s%d", 0
    fmt_int_str db "%d%s", 0
    cmd_speak_str db "powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%s') > NUL", 0
    cmd_speak_int db "powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%d') > NUL", 0
    str_1930363922_0 db "Caballero Oscuro", 0
    str_1180573051_1 db "Devorador de Mundos", 0
    str_1251138487_2 db "-----------------------------------------", 0
    str_1059115942_3 db "LA LEYENDA DE ", 0
    str_781403492_4 db " entra a la cueva prohibida...", 0
    str_814715001_5 db "De las sombras surge el ", 0
    str_1193979310_6 db "El combate a muerte comienza!", 0
    str_33700_7 db " ", 0
    str_61320585_8 db "--- Nuevo turno de combate ---", 0
    str_1135025266_9 db "El Dragon esta debil! ", 0
    str_983709577_10 db " prepara un golpe final.", 0
    str_780996930_11 db " ataca con su espada.", 0
    str_2115321587_12 db "PELIGRO! ", 0
    str_1816609457_13 db " bebe una pocion sagrada.", 0
    str_11089927_14 db "Pociones restantes: ", 0
    str_33560107_15 db "El ", 0
    str_96915630_16 db " escupe fuego infernal.", 0
    str_1639582591_17 db "¡MAGIA ACTIVA! Rafaga de velocidad:", 0
    str_83053767_18 db "ZAS! Corte rapido (-10 de vida al dragon).", 0
    str_781312804_19 db "Vida del Dragon restante:", 0
    str_1290556594_20 db "Vida del Heroe restante:", 0
    str_233612758_21 db "¡VICTORIA ABSOLUTA!", 0
    str_399296004_22 db " ha sido derrotado.", 0
    str_1600583395_23 db " regresa al reino como leyenda.", 0
    str_402440766_24 db "GAME OVER", 0
    str_605954821_25 db " ha caido en batalla...", 0

section .bss
    buffer resb 1024
    Heroe resd 1
    VidaHeroe resd 1
    Dragon resd 1
    VidaDragon resd 1
    Pociones resd 1
    TieneMagia resd 1
    Furia resd 1
    AtaqueBase resd 1
    T10 resd 1
    T13 resd 1
    T15 resd 1
    T18 resd 1
    T20 resd 1
    T21 resd 1
    T25 resd 1
    T27 resd 1
    T29 resd 1
    T31 resd 1
    T33 resd 1
    T34 resd 1
    T36 resd 1
    T38 resd 1
    T39 resd 1
    T41 resd 1
    T43 resd 1
    T45 resd 1
    T47 resd 1
    T50 resd 1
    T52 resd 1
    T54 resd 1
    T56 resd 1
    T58 resd 1
    Cortes resd 1
    T61 resd 1
    T62 resd 1
    T65 resd 1
    T66 resd 1
    T73 resd 1
    T76 resd 1
    T78 resd 1
    T80 resd 1
    T83 resd 1

global _main
extern _printf
extern _sprintf
extern _system
extern _exit
extern _strdup

section .text
_main:
    push ebp
    mov ebp, esp

    ; Heroe = "Caballero Oscuro"
    mov dword [Heroe], str_1930363922_0

    ; VidaHeroe = 100
    mov eax, 100
    mov [VidaHeroe], eax

    ; Dragon = "Devorador de Mundos"
    mov dword [Dragon], str_1180573051_1

    ; VidaDragon = 300
    mov eax, 300
    mov [VidaDragon], eax

    ; Pociones = 3
    mov eax, 3
    mov [Pociones], eax

    ; TieneMagia = true
    mov eax, 1
    mov [TieneMagia], eax

    ; Furia = false
    mov eax, 0
    mov [Furia], eax

    ; AtaqueBase = 50
    mov eax, 50
    mov [AtaqueBase], eax

    ; PRINT "-----------------------------------------"
    ; Imprimir en Pantalla
    push str_1251138487_2
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1251138487_2
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T10 = "LA LEYENDA DE " SUMA "Caballero Oscuro"
    ; -- Concat --
    push str_1930363922_0
    push str_1059115942_3
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T10], eax

    ; PRINT T10
    ; Imprimir en Pantalla
    push [T10]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T10]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; PRINT "-----------------------------------------"
    ; Imprimir en Pantalla
    push str_1251138487_2
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1251138487_2
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T13 = "Caballero Oscuro" SUMA " entra a la cueva prohibida..."
    ; -- Concat --
    push str_781403492_4
    push str_1930363922_0
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T13], eax

    ; PRINT T13
    ; Imprimir en Pantalla
    push [T13]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T13]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T15 = "De las sombras surge el " SUMA "Devorador de Mundos"
    ; -- Concat --
    push str_1180573051_1
    push str_814715001_5
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T15], eax

    ; PRINT T15
    ; Imprimir en Pantalla
    push [T15]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T15]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; PRINT "El combate a muerte comienza!"
    ; Imprimir en Pantalla
    push str_1193979310_6
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1193979310_6
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; L0:
L0:

    ; T18 = VidaDragon MAYOR 0
    mov eax, [VidaDragon]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T18], eax

    ; T20 = VidaHeroe MAYOR 0
    mov eax, [VidaHeroe]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T20], eax

    ; T21 = T18 AND T20
    mov eax, [T18]
    and eax, [T20]
    mov [T21], eax

    ; IF T21 GOTO L1
    mov eax, [T21]
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
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_33700_7
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; PRINT "--- Nuevo turno de combate ---"
    ; Imprimir en Pantalla
    push str_61320585_8
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_61320585_8
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T25 = VidaDragon MENOR 200
    mov eax, [VidaDragon]
    cmp eax, 200
    mov eax, 0
    setl al
    mov [T25], eax

    ; IF T25 GOTO L3
    mov eax, [T25]
    cmp eax, 0
    jne L3

    ; GOTO L4
    jmp L4

    ; L3:
L3:

    ; T27 = "El Dragon esta debil! " SUMA Heroe
    ; -- Concat --
    push [Heroe]
    push str_1135025266_9
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T27], eax

    ; T29 = T27 SUMA " prepara un golpe final."
    ; -- Concat --
    push str_983709577_10
    push [T27]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T29], eax

    ; PRINT T29
    ; Imprimir en Pantalla
    push [T29]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T29]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T31 = VidaDragon RESTA 100
    mov eax, [VidaDragon]
    sub eax, 100
    mov [T31], eax

    ; VidaDragon = T31
    mov eax, [T31]
    mov [VidaDragon], eax

    ; GOTO L5
    jmp L5

    ; L4:
L4:

    ; T33 = Heroe SUMA " ataca con su espada."
    ; -- Concat --
    push str_780996930_11
    push [Heroe]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T33], eax

    ; PRINT T33
    ; Imprimir en Pantalla
    push [T33]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T33]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T34 = VidaDragon RESTA AtaqueBase
    mov eax, [VidaDragon]
    sub eax, [AtaqueBase]
    mov [T34], eax

    ; VidaDragon = T34
    mov eax, [T34]
    mov [VidaDragon], eax

    ; L5:
L5:

    ; T36 = VidaHeroe MENOR 30
    mov eax, [VidaHeroe]
    cmp eax, 30
    mov eax, 0
    setl al
    mov [T36], eax

    ; T38 = Pociones MAYOR 0
    mov eax, [Pociones]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T38], eax

    ; T39 = T36 AND T38
    mov eax, [T36]
    and eax, [T38]
    mov [T39], eax

    ; IF T39 GOTO L6
    mov eax, [T39]
    cmp eax, 0
    jne L6

    ; GOTO L7
    jmp L7

    ; L6:
L6:

    ; T41 = "PELIGRO! " SUMA Heroe
    ; -- Concat --
    push [Heroe]
    push str_2115321587_12
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T41], eax

    ; T43 = T41 SUMA " bebe una pocion sagrada."
    ; -- Concat --
    push str_1816609457_13
    push [T41]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T43], eax

    ; PRINT T43
    ; Imprimir en Pantalla
    push [T43]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T43]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T45 = VidaHeroe SUMA 40
    mov eax, [VidaHeroe]
    add eax, 40
    mov [T45], eax

    ; VidaHeroe = T45
    mov eax, [T45]
    mov [VidaHeroe], eax

    ; T47 = Pociones RESTA 1
    mov eax, [Pociones]
    sub eax, 1
    mov [T47], eax

    ; Pociones = T47
    mov eax, [T47]
    mov [Pociones], eax

    ; PRINT "Pociones restantes: "
    ; Imprimir en Pantalla
    push str_11089927_14
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_11089927_14
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; PRINT T47
    ; Imprimir en Pantalla
    push dword [T47]
    push fmt_int
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push dword [T47]
    push cmd_speak_int
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; L7:
L7:

    ; T50 = VidaDragon MAYOR 0
    mov eax, [VidaDragon]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T50], eax

    ; IF T50 GOTO L8
    mov eax, [T50]
    cmp eax, 0
    jne L8

    ; GOTO L9
    jmp L9

    ; L8:
L8:

    ; T52 = "El " SUMA Dragon
    ; -- Concat --
    push [Dragon]
    push str_33560107_15
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T52], eax

    ; T54 = T52 SUMA " escupe fuego infernal."
    ; -- Concat --
    push str_96915630_16
    push [T52]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T54], eax

    ; PRINT T54
    ; Imprimir en Pantalla
    push [T54]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T54]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T56 = VidaHeroe RESTA 15
    mov eax, [VidaHeroe]
    sub eax, 15
    mov [T56], eax

    ; VidaHeroe = T56
    mov eax, [T56]
    mov [VidaHeroe], eax

    ; L9:
L9:

    ; T58 = TieneMagia IGUAL_QUE true
    mov eax, [TieneMagia]
    cmp eax, 1
    mov eax, 0
    sete al
    mov [T58], eax

    ; IF T58 GOTO L10
    mov eax, [T58]
    cmp eax, 0
    jne L10

    ; GOTO L11
    jmp L11

    ; L10:
L10:

    ; PRINT "¡MAGIA ACTIVA! Rafaga de velocidad:"
    ; Imprimir en Pantalla
    push str_1639582591_17
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1639582591_17
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; Cortes = 3
    mov eax, 3
    mov [Cortes], eax

    ; T61 = 3
    mov eax, 3
    mov [T61], eax

    ; L12:
L12:

    ; T62 = T61 MAYOR 0
    mov eax, [T61]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T62], eax

    ; IF T62 GOTO L13
    mov eax, [T62]
    cmp eax, 0
    jne L13

    ; GOTO L14
    jmp L14

    ; L13:
L13:

    ; PRINT "ZAS! Corte rapido (-10 de vida al dragon)."
    ; Imprimir en Pantalla
    push str_83053767_18
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_83053767_18
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T65 = VidaDragon RESTA 10
    mov eax, [VidaDragon]
    sub eax, 10
    mov [T65], eax

    ; VidaDragon = T65
    mov eax, [T65]
    mov [VidaDragon], eax

    ; T66 = T61 RESTA 1
    mov eax, [T61]
    sub eax, 1
    mov [T66], eax

    ; T61 = T66
    mov eax, [T66]
    mov [T61], eax

    ; GOTO L12
    jmp L12

    ; L14:
L14:

    ; TieneMagia = false
    mov eax, 0
    mov [TieneMagia], eax

    ; L11:
L11:

    ; PRINT "Vida del Dragon restante:"
    ; Imprimir en Pantalla
    push str_781312804_19
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_781312804_19
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; PRINT VidaDragon
    ; Imprimir en Pantalla
    push dword [VidaDragon]
    push fmt_int
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push dword [VidaDragon]
    push cmd_speak_int
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; PRINT "Vida del Heroe restante:"
    ; Imprimir en Pantalla
    push str_1290556594_20
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1290556594_20
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; PRINT VidaHeroe
    ; Imprimir en Pantalla
    push dword [VidaHeroe]
    push fmt_int
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push dword [VidaHeroe]
    push cmd_speak_int
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; GOTO L0
    jmp L0

    ; L2:
L2:

    ; PRINT " "
    ; Imprimir en Pantalla
    push str_33700_7
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_33700_7
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; PRINT "-----------------------------------------"
    ; Imprimir en Pantalla
    push str_1251138487_2
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1251138487_2
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T73 = VidaHeroe MAYOR 0
    mov eax, [VidaHeroe]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T73], eax

    ; IF T73 GOTO L15
    mov eax, [T73]
    cmp eax, 0
    jne L15

    ; GOTO L16
    jmp L16

    ; L15:
L15:

    ; PRINT "¡VICTORIA ABSOLUTA!"
    ; Imprimir en Pantalla
    push str_233612758_21
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_233612758_21
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T76 = "El " SUMA Dragon
    ; -- Concat --
    push [Dragon]
    push str_33560107_15
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T76], eax

    ; T78 = T76 SUMA " ha sido derrotado."
    ; -- Concat --
    push str_399296004_22
    push [T76]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T78], eax

    ; PRINT T78
    ; Imprimir en Pantalla
    push [T78]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T78]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T80 = Heroe SUMA " regresa al reino como leyenda."
    ; -- Concat --
    push str_1600583395_23
    push [Heroe]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T80], eax

    ; PRINT T80
    ; Imprimir en Pantalla
    push [T80]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T80]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; GOTO L17
    jmp L17

    ; L16:
L16:

    ; PRINT "GAME OVER"
    ; Imprimir en Pantalla
    push str_402440766_24
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_402440766_24
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T83 = Heroe SUMA " ha caido en batalla..."
    ; -- Concat --
    push str_605954821_25
    push [Heroe]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T83], eax

    ; PRINT T83
    ; Imprimir en Pantalla
    push [T83]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T83]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; L17:
L17:

    push 0
    call _exit
