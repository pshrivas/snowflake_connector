@echo off
REM SnowflakeV2 connector - server install script

IF /I "%~1" == "" goto displayUsage

IF /I "%~1" == "help" goto displayUsage

SET INFA_HOME=%~1

IF NOT EXIST "%INFA_HOME%" goto incorrectDir

robocopy "server" %INFA_HOME% /E /LOG:serverCopy.log >nul
IF %ERRORLEVEL% GTR 7 EXIT /B -%ERRORLEVEL%
goto end

:displayUsage

echo Usage: installServer infa_server_home
echo          infa_server_home  - this is the root directory for the server installation.

goto end

:incorrectDir
echo %INFA_HOME% is not a valid directory

:end
if "%OS%" == "Windows_NT" endlocal