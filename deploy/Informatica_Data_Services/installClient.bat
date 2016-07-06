@echo off
REM SnowflakeV2 connector - client install script

IF /I "%~1" == "" goto displayUsage

IF /I "%~1" == "help" goto displayUsage

SET INFA_CLIENT_HOME=%~1

IF NOT EXIST "%INFA_CLIENT_HOME%" goto incorrectDir


robocopy "client" "%INFA_CLIENT_HOME%" /E /LOG:clientCopy.log
IF %ERRORLEVEL% GTR 7 EXIT /B -%ERRORLEVEL%
robocopy "client/DeveloperClient/plugins" "%INFA_CLIENT_HOME%/DeveloperClient/osgi_plugins/jars/dynamic" /E /LOG:clientCmdCopy.log >nul
IF %ERRORLEVEL% GTR 7 EXIT /B -%ERRORLEVEL%
goto end

:displayUsage

echo Usage: installClient client_home
echo          client_home is the directory where DeveloperClient folder exists.

goto end

:incorrectDir
echo %INFA_CLIENT_HOME% is not a valid directory

:end
if "%OS%" == "Windows_NT" endlocal