
(ns dynamic-props.api
    (:require [dynamic-props.state :as state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-props
  ; @description
  ; Returns the dynamic properties of the component (stored in the properties state atom).
  ;
  ; @param (keyword) component-id
  ; @param (map)(opt) default-props
  ;
  ; @usage
  ; (get-props :my-component)
  ; =>
  ; {:my-prop "My value"}
  ;
  ; @usage
  ; (get-props :my-component {:my-prop "My default value" :another-prop "Another default value"})
  ; =>
  ; {:my-prop "My value"
  ;  :another-prop "Another default value"}
  ;
  ; @return (map)
  [component-id & [default-props]]
  (if-let [dynamic-props (get @state/PROPERTIES component-id)]
          (-> default-props (merge dynamic-props))
          (or default-props {})))

(defn import-props
  ; @description
  ; Merges the dynamic props of the component (stored in the properties state atom) onto the given properties map.
  ;
  ; @param (keyword) component-id
  ; @param (map)(opt) component-props
  ; @param (map)(opt) default-props
  ;
  ; @usage
  ; (import-props :my-component {...})
  ; =>
  ; {:my-prop "My value"
  ;  ...}
  ;
  ; @return (map)
  [component-id & [component-props default-props]]
  (if-let [dynamic-props (get-props component-id default-props)]
          (-> component-props (merge dynamic-props))
          (or component-props {})))
