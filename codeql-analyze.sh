#!/bin/bash

date

codeql database analyze local.db ../ql/java/ql/src/codeql-suites/java-lgtm-full.qls --format=sarif-latest --output=codeql-results.sarif

date
