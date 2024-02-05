
(ns dynamic-props.api
    #?(:cljs (:require [reagent.core :refer [atom] :rename {ratom}])))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @description
; Stored dynamic properties of components.
;
; @atom (map)
; {:my-component (map)}
;
; @usage
; (deref PROPERTIES)
; =>
; {:my-component {:my-prop "My value"}}
(def PROPERTIES #(:clj  (atom  {})
                  :cljs (ratom {})))
