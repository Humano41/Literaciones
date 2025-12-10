@echo off
title Compilando Historia
cls
echo [1/3] NASM: Generando codigo objeto...
nasm -f win32 historia.asm -o historia.obj
if %errorlevel% neq 0 ( echo [ERROR] Fallo en NASM & pause & exit )

echo [2/3] GCC: Creando ejecutable (Estrategia Segura)...
gcc historia.obj -m32
if %errorlevel% neq 0 ( echo [ERROR] Fallo en GCC & pause & exit )
if exist historia.exe del historia.exe
ren a.exe historia.exe

echo [3/3] EJECUTANDO HISTORIA:
echo ===============================================
historia.exe
echo ===============================================
echo Fin del programa.
pause
del historia.obj
