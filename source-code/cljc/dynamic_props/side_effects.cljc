
(ns dynamic-props.side-effects
    (:require [dynamic-props.state :as state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn update-props!
  ; @description
  ; Updates the dynamic properties of the component in the 'PROPERTIES' atom.
  ;
  ; @param (keyword) component-id
  ; @param (function) f
  ; @param (list of *)(opt) params
  ;
  ; @usage
  ; (update-props! :my-component assoc :my-prop "My dynamic property")
  [component-id f & params]
  (letfn [(f0 [%] (apply f % params))]
         (swap! state/PROPERTIES update component-id f0)))

(defn merge-props!
  ; @description
  ; Merges the given map onto the dynamic properties of the component in the 'PROPERTIES' atom.
  ;
  ; @param (keyword) component-id
  ; @param (map) updated-props
  ;
  ; @usage
  ; (merge-props! :my-component {:my-prop "My dynamic property"})
  [component-id updated-props]
  (update-props! component-id merge updated-props))

(defn clear-props!
  ; @description
  ; Clears the dynamic properties of the component from the 'PROPERTIES' atom.
  ;
  ; @param (keyword) component-id
  ;
  ; @usage
  ; (clear-props! :my-component)
  [component-id]
  (swap! state/PROPERTIES dissoc component-id))
