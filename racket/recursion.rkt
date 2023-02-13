#lang racket

; base case when n==0, return 1
; recursive step, return n * factorial(n-1)
(define (factorial n)
  (if (= n 0) 1 (* n (factorial (- n 1)))))

; base case when list is empty, return 0
; reursive step, return the sum of the head element plus the sum of the tail 
(define (sum lis)
  (if (empty? lis) 0 (+ (car lis) (sum (cdr lis)))))

; base case when the list is empty, return 0
; recursive step #1 when the head element is a list, return the sum of the head element list plus the sum of the tail
; recursive step #2 when the head element is NOT a list, return the sum of the head element plus the sum of the tail  
(define (sumdeep lis)
  (cond ((empty? lis) 0)
        ((list? (car lis)) (+ (sumdeep (car lis)) (sumdeep (cdr lis))))
        (else (+ (car lis) (sumdeep (cdr lis))))))

; same as previous but using let
(define (sumdeep2 lis)
  (if (empty? lis) 0
    (let ([head (car lis)] [tail (cdr lis)])
      (if (list? head)
        (+ (sumdeep2 head) (sumdeep2 tail))
        (+ head (sumdeep2 tail))))))