FROM clojure
COPY ./docker/profiles.clj /root/.lein/profiles.clj
WORKDIR /usr/src/kameleon

COPY project.clj /usr/src/kameleon/
RUN lein deps

COPY . /usr/src/kameleon
CMD ["lein", "test"]
