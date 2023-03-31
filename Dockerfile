FROM openjdk:11
RUN mkdir -p /usr/src/myapp
COPY out/artifacts/registration_jar/registration.jar /usr/src/myapp
COPY system.properties /usr/src/myapp
WORKDIR /usr/src/myapp
# RUN javac -cp Registration-jar-with-dependencies.jar com.jannetta.carpentries.registration.Main
EXPOSE 80
CMD ["java", "-cp", "registration.jar", "com.jannetta.carpentries.registration.Main"]