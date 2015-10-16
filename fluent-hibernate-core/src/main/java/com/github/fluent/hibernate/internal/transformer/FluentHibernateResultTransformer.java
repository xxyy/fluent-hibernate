package com.github.fluent.hibernate.internal.transformer;

import org.hibernate.transform.BasicTransformerAdapter;

import com.github.fluent.hibernate.internal.util.InternalUtils;

/**
 * @author DoubleF1re
 * @author V.Ladynev
 */
public class FluentHibernateResultTransformer extends BasicTransformerAdapter {

    private static final long serialVersionUID = 6825154815776629666L;

    private final Class<?> resultClass;

    private Setter[] setters;

    public FluentHibernateResultTransformer(Class<?> resultClass) {
        this.resultClass = resultClass;
    }

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        if (setters == null) {
            setters = createSetters(resultClass, aliases);
        }

        Object result = InternalUtils.newInstance(resultClass);

        for (int i = 0; i < aliases.length; i++) {
            setters[i].set(result, tuple[i]);
        }

        return result;
    }

    private static Setter[] createSetters(Class<?> resultClass, String[] aliases) {
        SetterAccessor propertyAccessor = new SetterAccessor();
        Setter[] result = new Setter[aliases.length];
        for (int i = 0; i < aliases.length; i++) {
            String alias = aliases[i];
            result[i] = propertyAccessor.getSetter(resultClass, alias);
        }

        return result;
    }

}