section .data
    fmt_int db "%d", 10, 0
    fmt_str db "%s", 10, 0
    fmt_str_str db "%s%s", 0
    fmt_str_int db "%s%d", 0
    fmt_int_str db "%d%s", 0
    cmd_speak_str db "powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%s') > NUL", 0
    cmd_speak_int db "powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%d') > NUL", 0
    str_1490997218_0 db "Valiente", 0
    str_674893415_1 db " se despierta listo para la aventura.", 0
    str_1195424247_2 db "Valiente corre por el bosque buscando pistas.", 0
    str_448346871_3 db "Valiente está cansado y decide descansar.", 0
    str_1381150776_4 db " esta perdiendo energia ahora tiene ", 0
    str_1042313220_5 db "HOLA", 0
    str_665476664_6 db " se  ha agotado", 0

section .bss
    buffer resb 1024
    HEROE resd 1
    ENERGIA resd 1
    T3 resd 1
    T9 resd 1
    T11 resd 1
    T12 resd 1
    T14 resd 1
    T16 resd 1
    T17 resd 1
    T19 resd 1
    T21 resd 1

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

    ; HEROE = "Valiente"
    mov dword [HEROE], str_1490997218_0

    ; ENERGIA = 10
    mov eax, 10
    mov [ENERGIA], eax

    ; T3 = "Valiente" SUMA " se despierta listo para la aventura."
    ; -- Concat --
    push str_674893415_1
    push str_1490997218_0
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T3], eax

    ; PRINT T3
    ; Imprimir en Pantalla
    push [T3]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T3]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; IF true GOTO L0
    mov eax, 1
    cmp eax, 0
    jne L0

    ; GOTO L1
    jmp L1

    ; L0:
L0:

    ; PRINT "Valiente corre por el bosque buscando pistas."
    ; Imprimir en Pantalla
    push str_1195424247_2
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1195424247_2
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; GOTO L2
    jmp L2

    ; L1:
L1:

    ; PRINT "Valiente está cansado y decide descansar."
    ; Imprimir en Pantalla
    push str_448346871_3
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_448346871_3
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; L2:
L2:

    ; L3:
L3:

    ; T9 = ENERGIA MAYOR 0
    mov eax, [ENERGIA]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T9], eax

    ; IF T9 GOTO L4
    mov eax, [T9]
    cmp eax, 0
    jne L4

    ; GOTO L5
    jmp L5

    ; L4:
L4:

    ; T11 = HEROE SUMA " esta perdiendo energia ahora tiene "
    ; -- Concat --
    push str_1381150776_4
    push [HEROE]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T11], eax

    ; T12 = T11 SUMA ENERGIA
    ; -- Concat --
    push dword [ENERGIA]
    push [T11]
    push fmt_str_int
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T12], eax

    ; PRINT T12
    ; Imprimir en Pantalla
    push [T12]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T12]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T14 = ENERGIA RESTA 2
    mov eax, [ENERGIA]
    sub eax, 2
    mov [T14], eax

    ; ENERGIA = T14
    mov eax, [T14]
    mov [ENERGIA], eax

    ; GOTO L3
    jmp L3

    ; L5:
L5:

    ; T16 = 2
    mov eax, 2
    mov [T16], eax

    ; L6:
L6:

    ; T17 = T16 MAYOR 0
    mov eax, [T16]
    cmp eax, 0
    mov eax, 0
    setg al
    mov [T17], eax

    ; IF T17 GOTO L7
    mov eax, [T17]
    cmp eax, 0
    jne L7

    ; GOTO L8
    jmp L8

    ; L7:
L7:

    ; PRINT "HOLA"
    ; Imprimir en Pantalla
    push str_1042313220_5
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push str_1042313220_5
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; T19 = T16 RESTA 1
    mov eax, [T16]
    sub eax, 1
    mov [T19], eax

    ; T16 = T19
    mov eax, [T19]
    mov [T16], eax

    ; GOTO L6
    jmp L6

    ; L8:
L8:

    ; T21 = HEROE SUMA " se  ha agotado"
    ; -- Concat --
    push str_665476664_6
    push [HEROE]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    push buffer
    call _strdup
    add esp, 4
    mov [T21], eax

    ; PRINT T21
    ; Imprimir en Pantalla
    push [T21]
    push fmt_str
    call _printf
    add esp, 8
    ; Narrar con PowerShell
    push [T21]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    push 0
    call _exit
