FROM mcr.microsoft.com/windows/servercore:ltsc2022

WORKDIR "C:/ProgramData"

# install Java via chocolately
RUN @powershell -NoProfile -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin" -Y
RUN choco install openjdk17 -Y
RUN refreshenv

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} "C:/ProgramData/app.jar"

EXPOSE 8080

CMD ["java", "-jar", "C:/ProgramData/app.jar"]
