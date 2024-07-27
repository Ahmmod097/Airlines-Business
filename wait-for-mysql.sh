#!/bin/bash

set -e

host="$1"
shift
cmd="$@"

while ! (echo > /dev/tcp/$host/3306) &> /dev/null; do
  echo "Waiting for MySQL to be available at $host:3306"
  sleep 2
done

>&2 echo "MySQL is up - executing command"
exec $cmd