#!/bin/bash

rm pushImage.sh

mvn clean package docker:build

./pushImage.sh