#lang racket

; calculates the area of a rectangle
(define (areaOfRectangle w h) (* w h))

; calculates the area of a circle
(define (areaCircle r) (* pi r r))
(define (areaCircl2 r) (* pi (expt r 2)))

; demonstrate the "if" function
; returns 0 if width or height is negative
(define (safe_areaRectangle w h)
  (if
    (or (< w 0) (< h 0))
    0
    (* w h)))

; returns analysis of the weather based on the following temperature ranges
; 80+ = hot
; 60+ = mild
; 40+ - cool
; <40 = cold
(define (qualifyWeather degF)
  (cond ((>= degF 80) (print "hi there it must be hot") "hot")
        ((>= degF 60) (print "mild out today, huh") "mild")
        ((>= degF 40) (print "cool") "cool")
        (else "cold")))

; list functions
(quote (3 4 5))
'(3 4 5) ; equivalent to previous
(sort '(5 2 8 9) <)
(cons 1 '(2 3 4))
(car '(1 2 3 4))
(cdr '(1 2 3 4))
(cdr '(1))
(list 1 2 3 4)
(append '(1 2) '(3 4))

