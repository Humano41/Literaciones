@echo off
title Compilando Historia
cls
nasm -f win32 historia.asm -o historia.o
if %errorlevel% neq 0 ( echo [ERROR] Fallo en NASM & pause & exit )

gcc historia.o -lmsvcrt -Wl,--entry=_main
if %errorlevel% neq 0 ( echo [ERROR] Fallo en GCC durante el enlazado & pause & exit )
if not exist a.exe ( echo [ERROR FATAL] GCC no pudo generar a.exe. & pause & exit )
if exist historia.exe del historia.exe
ren a.exe historia.exe

echo ===============================================
historia.exe
echo ===============================================
echo Fin del programa.
pause
del historia.o
