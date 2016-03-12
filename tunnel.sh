#!/bin/bash
ssh -f -N -L 8081:localhost:8080 samsik@109.234.36.108
ssh -f -N -L 9992:localhost:9990 samsik@109.234.36.108
ssh -f -N -L 5432:localhost:5432 samsik@109.234.36.108
ssh -f -N -L 8787:localhost:8787 samsik@109.234.36.108