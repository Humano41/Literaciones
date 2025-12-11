@echo off
title Compilando Historia
cls
"herramientas\nasm.exe" -f win32 historia.asm -o historia.obj
if %errorlevel% neq 0 ( echo [ERROR] Fallo en NASM & pause & exit )

"herramientas\golink.exe" /console /entry _main historia.obj msvcrt.dll kernel32.dll
if %errorlevel% neq 0 ( echo [ERROR] Fallo en GoLink & pause & exit )
echo ===============================================
historia.exe
echo ===============================================
echo Fin del programa.
pause
del historia.obj
