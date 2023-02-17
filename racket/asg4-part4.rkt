#lang racket

; part 4 - custom sort
(define (lensort a b)
  (< (length a) (length b)))

; include a "call" below to the sort function to sort a nested list passing in the lensort function as the second parameter