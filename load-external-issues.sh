#!/bin/bash

mvn clean package -DskipTests=true sonar:sonar \
    -Dsonar.login=admin \
    -Dsonar.password=admin \
    -Dsonar.scm.disabled=true \
    -Dsonar.cpd.exclusions=** \
    -Dsonar.branch.autoconfig.disabled=true \
    -Dsonar.c.file.suffixes=- \
    -Dsonar.cpp.file.suffixes=- \
    -Dsonar.objc.file.suffixes=- \
    -Dsonar.externalIssuesReportPaths=sonarqube-external-issues.json
