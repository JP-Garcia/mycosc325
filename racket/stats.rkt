#lang racket

; base case when lis is emtpy, return 0
; recursive step, add the head element to the sum of the tail
(define (sum lis)
  (if (empty? lis) 0 (+ (car lis) (sum (cdr lis)))))

; mean - average, i.e., total / count
; no error checking, will crash if passed an empty list
(define (mean lis)
  (/ (sum lis) (length lis)))

; returns the element at position i from within lis (0-based)
(define (elementAt lis i)
  (if (= i 0)(car lis) (elementAt (cdr lis) (- i 1))))
  
; median - middle of the sorted version of the list
;  even case - return the average of the two items that are in the middle
;  odd case - return the middle item
; 
(define (median lis)
  (let* ([sortedlis (sort lis <)] [len (length lis)] [middle (floor (/ len 2))])
    (if (even? len)
        (/ (+ (elementAt sortedlis middle) (elementAt sortedlis (- middle 1))) 2)
        (elementAt sortedlis middle))))

; mode is defined in separate file (stats-mode.rkt)

; below I have corrected the sumdeep function using let (which had a mistake)
; recall that sumdeep is designed to work on nested lists ... whereas the "sum" function defined at the top of this file can only work on simple non-nested lists
(define (sumdeep lis)
  (if (empty? lis) 0
     (let ([head (car lis)] [tail (cdr lis)])
       (if (list? head) (+ (sumdeep head) (sumdeep tail)) (+ head (sumdeep tail))))))