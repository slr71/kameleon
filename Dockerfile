FROM clojure
COPY . /usr/src/kameleon
COPY ./docker/profiles.clj /root/.lein/profiles.clj
WORKDIR /usr/src/kameleon
RUN lein deps
CMD ["lein", "test"]
