#lang racket

; countElement - returns how many times elem appears in the list
(define (countElement lis elem)
  (cond ((empty? lis) 0)
        ((= (car lis) elem) (+ 1 (countElement (cdr lis) elem)))
        (else (countElement (cdr lis) elem))))


; return how many times each of the elemnts in lis1 appears in lis2
; the return value is a nested list of lists where each mini-list is of the form '(element count)
(define (countAll lis1 lis2)
  (if (empty? lis1) '() (append (list (list (car lis1) (countElement lis2 (car lis1)))) (countAll (cdr lis1) lis2))))

; returns the max element count of the form (elem count)
;  where counts is of the form '((elem1 count1) (elem2 count2) (elem3 count3) etc...)
;  base case when empty list, return empty list
;  another base case when the tail of the list is empty, then the head count is the max element
;  recursive step, find the max of the tail and compare the head element to it
(define (findMaxMode counts)
  (if (empty? counts) '()
      (let ([headcount (car counts)] [tailmax (findMaxMode (cdr counts))])
        (cond ((empty? tailmax) headcount)
              ((> (cadr headcount) (cadr tailmax)) headcount)
              (else tailmax)))))
   
; mode - return the element that occurs the most
; algorithm is to find the unique elements by converting to a set (which removes duplicates) and then converting back to a list
(define (mode lis)
  (let ([counts (countAll (set->list (list->set lis)) lis)])
    (findMaxMode counts)))