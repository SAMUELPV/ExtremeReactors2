/*
 *
 * AbstractFluidPortHandler.java
 *
 * This file is part of Extreme Reactors 2 by ZeroNoRyouki, a Minecraft mod.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 * DO NOT REMOVE OR EDIT THIS HEADER
 *
 */

package it.zerono.mods.extremereactors.gamecontent.multiblock.common.part.fluidport;

import it.zerono.mods.extremereactors.gamecontent.multiblock.common.AbstractGeneratorMultiblockController;
import it.zerono.mods.extremereactors.gamecontent.multiblock.common.part.AbstractIOPortHandler;
import it.zerono.mods.extremereactors.gamecontent.multiblock.common.variant.IMultiblockGeneratorVariant;
import it.zerono.mods.zerocore.lib.data.IIoEntity;
import it.zerono.mods.zerocore.lib.data.IoMode;
import it.zerono.mods.zerocore.lib.multiblock.cuboid.AbstractCuboidMultiblockPart;

public abstract class AbstractFluidPortHandler<Controller extends AbstractGeneratorMultiblockController<Controller, V>,
            V extends IMultiblockGeneratorVariant, P extends AbstractCuboidMultiblockPart<Controller> & IIoEntity>
        extends AbstractIOPortHandler<Controller, V>
        implements IFluidPortHandler<Controller, V> {

    protected AbstractFluidPortHandler(final FluidPortType type, final P part, final IoMode mode) {

        super(part, mode);
        this._type = type;
    }

    public P getIoEntity() {
        //noinspection unchecked
        return (P)this.getPart();
    }

    public boolean isInput() {
        return this.getIoEntity().getIoDirection().isInput();
    }

    public boolean isOutput() {
        return this.getIoEntity().getIoDirection().isOutput();
    }

    //region IFluidPortHandler

    /**
     * Get the {@link FluidPortType} supported by this IFluidPortHandler
     *
     * @return the supported {@link FluidPortType}
     */
    @Override
    public FluidPortType getFluidPortType() {
        return this._type;
    }

    //endregion
    //region internals

    private final FluidPortType _type;


    //endregion
}
