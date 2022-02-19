package me.ahoo.cosid;

/**
 * IdGenerator decorator.
 *
 * @author ahoo wang
 */
public interface IdGeneratorDecorator extends IdGenerator {
    /**
     * Get decorator actual id generator.
     *
     * @return actual id generator
     */
    IdGenerator getActual();
    
    static <T extends IdGenerator> T getActual(IdGenerator idGenerator) {
        if (idGenerator instanceof IdGeneratorDecorator) {
            return getActual(((IdGeneratorDecorator) idGenerator).getActual());
        }
        return (T) idGenerator;
    }
    
    @Override
    default long generate() {
        return getActual().generate();
    }
    
}