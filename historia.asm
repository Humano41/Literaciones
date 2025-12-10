section .data
    fmt_int db "%d", 10, 0
    fmt_str db "%s", 10, 0
    fmt_str_str db "%s%s", 0
    fmt_str_int db "%s%d", 0
    cmd_speak_str db "powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%s')", 0
    cmd_speak_int db "powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%d')", 0
    str_1490997218 db "Valiente", 0
    str_674893415 db " se despierta listo para la aventura.", 0
    str_1195424247 db "Valiente corre por el bosque buscando pistas.", 0
    str_448346871 db "Valiente está cansado y decide descansar.", 0
    str_1381150776 db " esta perdiendo energia ahora tiene ", 0
    str_665476664 db " se  ha agotado", 0

section .bss
    HEROE resd 1
    ENERGIA resd 1
    buffer resb 512
    HEROE resd 1
    ENERGIA resd 1
    T3 resd 1
    T9 resd 1
    T11 resd 1
    T13 resd 1
    T14 resd 1
    T16 resd 1

global _main
extern _printf
extern _sprintf
extern _system
extern _exit

section .text
_main:
    push ebp
    mov ebp, esp

    ; HEROE = "Valiente"
    mov dword [HEROE], str_1490997218

    ; ENERGIA = 10
    mov eax, 10
    mov [ENERGIA], eax

    ; T3 = "Valiente" SUMA " se despierta listo para la aventura."
    ; -- INICIO CONCATENACION --
    push str_674893415
    push str_1490997218
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    mov dword [T3], buffer
    ; -- FIN CONCATENACION --

    ; PRINT T3
    push dword [T3]
    push fmt_str
    call _printf
    add esp, 8
    push dword [T3]
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
    push str_1195424247
    push fmt_str
    call _printf
    add esp, 8
    push str_1195424247
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
    push str_448346871
    push fmt_str
    call _printf
    add esp, 8
    push str_448346871
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

    ; T11 = ENERGIA RESTA 2
    mov eax, [ENERGIA]
    sub eax, 2
    mov [T11], eax

    ; ENERGIA = T11
    mov eax, [T11]
    mov [ENERGIA], eax

    ; T13 = HEROE SUMA " esta perdiendo energia ahora tiene "
    ; -- INICIO CONCATENACION --
    push str_1381150776
    push [HEROE]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    mov dword [T13], buffer
    ; -- FIN CONCATENACION --

    ; T14 = T13 SUMA T11
    ; -- INICIO CONCATENACION --
    push [T11]
    push [T13]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    mov dword [T14], buffer
    ; -- FIN CONCATENACION --

    ; PRINT T14
    push dword [T14]
    push fmt_str
    call _printf
    add esp, 8
    push dword [T14]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    ; GOTO L3
    jmp L3

    ; L5:
L5:

    ; T16 = HEROE SUMA " se  ha agotado"
    ; -- INICIO CONCATENACION --
    push str_665476664
    push [HEROE]
    push fmt_str_str
    push buffer
    call _sprintf
    add esp, 16
    mov dword [T16], buffer
    ; -- FIN CONCATENACION --

    ; PRINT T16
    push dword [T16]
    push fmt_str
    call _printf
    add esp, 8
    push dword [T16]
    push cmd_speak_str
    push buffer
    call _sprintf
    add esp, 12
    push buffer
    call _system
    add esp, 4

    push 0
    call _exit
