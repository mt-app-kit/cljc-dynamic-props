
(ns dynamic-props.side-effects
    (:require [dynamic-props.state :as state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn update-props!
  ; @description
  ; Updates the dynamic properties of the component (stored in the properties state atom).
  ;
  ; @param (keyword) component-id
  ; @param (function) f
  ; @param (list of *) params
  ;
  ; @usage
  ; (update-props! :my-component assoc :my-prop "My value")
  ;
  ; @usage
  ; (update-props! :my-component assoc :my-prop "My value")
  ; (defn my-component
  ;   [props]
  ;   (let [props (import-props props)]) ...)
  [component-id f & params]
  (letfn [(f0 [%] (apply f % params))]
         (swap! state/PROPERTIES update component-id f0)))

(defn clear-props!
  ; @description
  ; Clears the dynamic properties of the component from the properties state atom.
  ;
  ; @param (keyword) component-id
  ;
  ; @usage
  ; (clear-props! :my-component)
  [component-id]
  (swap! state/PROPERTIES dissoc component-id))
