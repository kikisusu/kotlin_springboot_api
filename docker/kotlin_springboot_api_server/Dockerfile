FROM openjdk:21-slim
ENV APP_ROOT /usr/src/app
ENV TZ=Asia/Tokyo

RUN date

WORKDIR $APP_ROOT

USER root

RUN apt-get update && apt-get install -y \
	curl \
	zip \
	bash

RUN ln -s /lib/libc.musl-x86_64.so.1 /lib/ld-linux-x86-64.so.2

RUN curl -s https://get.sdkman.io | bash

RUN bash -c " \
	source "$HOME/.sdkman/bin/sdkman-init.sh" && \
	sdk install kotlin 1.9.22 \
	"
