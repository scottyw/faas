FROM clojure:lein-2.7.1-alpine

ADD https://github.com/alexellis/faas/releases/download/0.5.1-alpha/fwatchdog /usr/bin
RUN chmod +x /usr/bin/fwatchdog

COPY openfaas-handler/src /root/openfaas-handler/src
COPY openfaas-handler/project.clj /root/openfaas-handler

WORKDIR /root/openfaas-handler/

RUN lein uberjar

ENV fprocess="java -jar /root/openfaas-handler/target/openfaas-handler-0.1.0-SNAPSHOT-standalone.jar"

HEALTHCHECK --interval=1s CMD [ -e /tmp/.lock ] || exit 1

CMD ["fwatchdog"]
